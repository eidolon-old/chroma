# Chroma [![Build Status](https://api.travis-ci.org/eidolon/chroma.svg)](https://travis-ci.org/eidolon/chroma)

Chroma is a Scala console colours library, based on the Node [Chalk library][1]. Chroma is designed
to be ridiculously simple, lightweight, and easy to use.


## Installation

Add the repo `https://repo.eidolonframework.com/` to your project build file. Then add the library
as a dependency.

```
"eidolon" %% "chroma" % "1.0.0"
```


## Usage

Chroma has an easy to learn, composable API that allows you to chain and nest styles you want.

```scala
val chroma = Chroma()

// Style a string
println(chroma.blue("Hello world!"))

// Combine styled and normal strings
println(chroma.blue("Hello") + " world" + chroma.red("!"))

// Compose multiple styles using the chainable API
println(chroma.white.bgMagenta.bold("Hello world!"))

// Pass in multiple arguments
println(chroma.blue("Hello", "world", "!"))

// Nest styles
println(chroma.red("Hello", chroma.underline.bgBlue("world") + "!"))

// Nest styles of the same type even (colour, underline, background)
println(chroma.green(
    "I am a green line " +
    chroma.blue.underline.bold("with a blue substring") +
    " that becomes green again!"
))
```


## Supported Styles

### Modifiers

* `reset`
* `bold`
* `dim`
* `italics` _(not widely supported)_
* `underline`
* `inverse`
* `hidden`
* `strikethrough` _(not widely supported)_

### Colours

* `black`
* `red`
* `green`
* `yellow`
* `blue` _(on Windows this may be illegible, see 'Windows Users' section)_
* `magenta`
* `cyan`
* `white`
* `gray`
* `grey`

### Background Colours

* `bgBlack`
* `bgRed`
* `bgGreen`
* `bgYellow`
* `bgBlue`
* `bgMagenta`
* `bgCyan`
* `bgWhite`


## Windows Users

Get a real terminal if you're planning on using this.


## License

MIT


[1]: https://github.com/chalk/chalk
