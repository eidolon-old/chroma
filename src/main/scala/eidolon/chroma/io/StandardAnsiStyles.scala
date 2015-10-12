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

/**
 * AnsiStyles
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
final class StandardAnsiStyles extends AnsiStyles {
    private val styles = Map(
        // Colours
        "black" -> List(30, 39),
        "red" -> List(31, 39),
        "green" -> List(32, 39),
        "yellow" -> List(33, 39),
        "blue" -> List(34, 39),
        "magenta" -> List(35, 39),
        "cyan" -> List(36, 39),
        "white" -> List(37, 39),
        "gray" -> List(90, 39),
        "grey" -> List(90, 39),

        // Backgrounds
        "bgBlack" -> List(40, 49),
        "bgRed" -> List(41, 49),
        "bgGreen" -> List(42, 49),
        "bgYellow" -> List(43, 49),
        "bgBlue" -> List(44, 49),
        "bgMagenta" -> List(45, 49),
        "bgCyan" -> List(46, 49),
        "bgWhite" -> List(47, 49),

        // Modifiers
        "reset" -> List(0, 0),
        "bold" -> List(1, 22),
        "dim" -> List(2, 22),
        "italics" -> List(3, 23),
        "underline" -> List(4, 24),
        "inverse" -> List(7, 27),
        "hidden" -> List(8, 28),
        "strikethrough" -> List(9, 29)
    )

    /**
     * @inheritdoc
     */
    @throws[StyleNotFoundException]("If an invalid/non-existent style is requested")
    def getStyle(name: String): AnsiStyle = {
        if (!styles.contains(name)) {
            throw new StyleNotFoundException(s"No style found with name: '$name'")
        }

        new AnsiStyle(
            styles(name).head,
            styles(name).last
        )
    }
}
