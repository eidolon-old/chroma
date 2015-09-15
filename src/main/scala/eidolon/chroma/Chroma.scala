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

import eidolon.chroma.io.{AnsiStyles, StandardAnsiStyles}

import scala.collection.immutable.Queue
import scala.language.dynamics

/**
 * Chroma
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
class Chroma(styles: AnsiStyles, queue: Queue[String] = Queue()) extends Dynamic {
    /**
     * Queue up more styles
     *
     * @param name Name of style to queue
     * @return New Chroma instance with new style added to queue
     */
    def selectDynamic(name: String): Chroma = {
        new Chroma(styles, queue :+ name)
    }

    /**
     * Apply styles to the given input
     *
     * @param name Name of final style to apply
     * @param args The input to apply styles to
     * @return The styled input (if possible)
     */
    def applyDynamic(name: String)(args: String*): String = {
        val res = queue :+ name
        var str = args.mkString(" ")

        res.foreach((style: String) => {
            val code = styles.getStyle(style)

            str = code.open + str + code.close
        })

        str
    }
}

/**
 * Factory companion, to use sensible defaults quickly and easily
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
object Chroma {
    def apply(): Chroma = {
        new Chroma(new StandardAnsiStyles())
    }
}
