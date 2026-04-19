# {{raw-name}}

A Clojure project using [meme](https://github.com/xpojure-lang/meme-clj) — M-expression syntax.

## Usage

```bash
# Run a .meme file
clojure -X:run run :file '"src/{{top/file}}/{{main/file}}/core.meme"'

# Start a meme REPL
clojure -X:run repl

# Convert .meme to .clj (or .clj to .meme)
clojure -X:run to-clj :file '"src/{{top/file}}/{{main/file}}/core.meme"'
clojure -X:run to-meme :file '"src/{{top/file}}/{{main/file}}/core.clj"'

# Run tests
clojure -X:test

# Build a JAR (transpiles .meme → .clj, AOT-compiles, packages)
clojure -T:build jar
```

## Syntax

One rule: `f(x y)` becomes `(f x y)` — the head is written outside the parens, adjacent to `(`.

Everything else is Clojure. File extension: `.meme`.
