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

        when(styles.getStyle("test")).thenReturn(new AnsiStyle("<start>", "<end>"))

        chroma = new Chroma(styles)
    }

    describe("eidolon.chroma.Chroma") {
        it("should be an instance of Dynamic") {
            assert(chroma.isInstanceOf[Dynamic])
        }

        describe("selectDynamic()") {
            it("return a new Chroma instance") {
                val result = chroma.selectDynamic("test")

                assert(result.isInstanceOf[Chroma])
                assert(result != chroma)
            }
        }

        describe("applyDynamic()") {
            it("return a string") {
                val result = chroma.applyDynamic("test")("Hello world!")

                assert(result.isInstanceOf[String])
            }

            it("should apply the styles to the input") {
                val result = chroma.applyDynamic("test")("Hello world!")
                val expected = "<start>Hello world!<end>"

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
