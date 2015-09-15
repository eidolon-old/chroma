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

package eidolon.chroma.io

import eidolon.chroma.io.exception.StyleNotFoundException
import org.scalatest.{BeforeAndAfter, FunSpec}

/**
 * StandardAnsiStylesSpec
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
class StandardAnsiStylesSpec extends FunSpec with BeforeAndAfter {
    private var ansiStyles: StandardAnsiStyles = _

    before {
        ansiStyles = new StandardAnsiStyles()
    }

    describe("eidolon.chroma.io.StandardAnsiStyles") {
        it("should be an instance of AnsiStyles") {
            assert(ansiStyles.isInstanceOf[AnsiStyles])
        }

        describe("getStyle()") {
            it("should throw StyleNotFoundException if given style does not exist") {
                intercept[StyleNotFoundException] {
                    ansiStyles.getStyle("test")
                }
            }

            it("should return an instance of AnsiStyle") {
                val result = ansiStyles.getStyle("bold")

                assert(result.isInstanceOf[AnsiStyle])
            }
        }
    }
}
