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

/**
 * Data storage object for a style
 *
 * @param open Opening style string
 * @param close Closing style string
 */
case class AnsiStyle(open: Int, close: Int) {
    private val openSeq = s"\u001b[${open}m"
    private val closeSeq = s"\u001b[${close}m"

    /**
     * Apply this style to the given input
     *
     * @param input The unstyled input
     * @return The styled output
     */
    def applyStyle(input: String): String = {
        openSeq + input.replaceAllLiterally(closeSeq, openSeq) + closeSeq
    }
}
