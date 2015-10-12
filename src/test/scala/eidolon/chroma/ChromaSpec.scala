/**
 * This file is part of the "chroma" project.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the LICENSE is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package eidolon.chroma

import eidolon.chroma.io.{AnsiStyle, AnsiStyles}
import org.mockito.Mockito._
import org.scalatest.{BeforeAndAfter, FunSpec}

/**
 * ChromaSpec
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
class ChromaSpec extends FunSpec with BeforeAndAfter {
    private var chroma: Chroma = _

    before {
        val styles = mock(classOf[AnsiStyles])

        when(styles.getStyle("test1")).thenReturn(new AnsiStyle(1, 10))
        when(styles.getStyle("test2")).thenReturn(new AnsiStyle(1, 20))
        when(styles.getStyle("test3")).thenReturn(new AnsiStyle(2, 20))

        chroma = new Chroma(styles)
    }

    describe("eidolon.chroma.Chroma") {
        it("should be an instance of Dynamic") {
            assert(chroma.isInstanceOf[Dynamic])
        }

        describe("selectDynamic()") {
            it("return a new Chroma instance") {
                val result = chroma.selectDynamic("test1")

                assert(result.isInstanceOf[Chroma])
                assert(result != chroma)
            }
        }

        describe("applyDynamic()") {
            it("return a string") {
                val result = chroma.applyDynamic("test1")("Hello world!")

                assert(result.isInstanceOf[String])
            }

            it("should apply the styles to the input") {
                val result = chroma.applyDynamic("test1")("Hello world!")
                val expected = "\u001b[1mHello world!\u001b[10m"

                assert(result == expected)
            }

            it("should be able to apply multiple styles to a given input") {
                val broker = chroma.applyDynamic("test1")("Hello world!")
                val result = chroma.applyDynamic("test2")(broker)
                val expected = "\u001b[1m\u001b[1mHello world!\u001b[10m\u001b[20m"

                assert(result == expected)
            }

            it("should be able to apply several of the same kinds of styles to the same input") {
                val inner = chroma.applyDynamic("test2")("world")
                val result = chroma.applyDynamic("test3")("Hello " + inner + "!")
                val expected = "\u001b[2mHello \u001b[1mworld\u001b[2m!\u001b[20m"

                assert(result == expected)
            }
        }
    }

    describe("eidolon.chroma.Chroma()") {
        it("should return a new instance of Chroma") {
            assert(Chroma().isInstanceOf[Chroma])
        }
    }
}
