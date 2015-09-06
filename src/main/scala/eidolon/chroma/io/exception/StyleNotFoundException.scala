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

package eidolon.chroma.io.exception

/**
 * StyleNotFoundException
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
case class StyleNotFoundException(message: String) extends Exception(message)
