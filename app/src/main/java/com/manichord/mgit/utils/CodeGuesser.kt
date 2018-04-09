package com.manichord.mgit.utils

import java.util.*

/**
 * Created by sheimi on 8/23/13.
 */
object CodeGuesser {

    private val FILENAME_EXTENSION_ARRAY = arrayOf(
            arrayOf("APL", "text/apl", "apl"),
            arrayOf("Asterisk dialplan", "text/x-asterisk", "conf"),
            arrayOf("C", "text/x-csrc", "c", "m"),
            arrayOf("C++", "text/x-c++src", "cpp", "cc", "hpp", "hh", "h"),
            arrayOf("C#", "text/x-csharp", "cs"),
            arrayOf("C-Shell", "application/x-csh", "csh"),
            arrayOf("Java", "text/x-java", "java"),
            arrayOf("CLIPS", "application/x-msclip", "clp"),
            arrayOf("Clojure", "text/x-clojure.", "clj", "cljs"),
            arrayOf("COBOL", "text/x-cobol", "cbl"),
            arrayOf("CoffeeScript", "text/x-coffeescript", "coffee"),
            arrayOf("Lisp", "text/x-common-lisp", "lisp", "lsp", "el", "cl", "jl", "L", "emacs", "sawfishrc"),
            arrayOf("CSS", "text/css", "css"), arrayOf("Scss", "text/x-scss", "scss"),
            arrayOf("Sass", "text/x-sass", "sass"),
            arrayOf("Less", "text/x-x-less", "less"),
            arrayOf("D", "text/x-d", "d"),
            arrayOf("Diff", "text/x-diff", "diff", "patch", "rej"),
            arrayOf("DTD", "application/xml-dtd"),
            arrayOf("ECL", "text/x-ecl", "ecl"),
            arrayOf("Eiffel", "text/x-eiffel", "e"),
            arrayOf("Erlang", "text/x-erlang", "erl", "hrl", "yaws"),
            arrayOf("Fortran", "text/x-Fortran", "f", "for", "f90", "f95"),
            arrayOf("Gas", "text/x-gas", "as", "gas"),
            arrayOf("Go", "text/x-go", "go"),
            arrayOf("Groovy", "text/x-groovy", "groovy", "gvy", "gy", "gsh"),
            arrayOf("HAML", "text/x-haml", "haml"),
            arrayOf("Haskell", "text/x-haskell", "hs"),
            arrayOf("ASP.net", "text/x-aspx", "asp", "aspx"),
            arrayOf("JSP", "text/x-jsp", "jsp"),
            arrayOf("HTML", "text/html", "html", "htm", "xhtml"),
            arrayOf("Jade", "text/x-jade", "jade"),
            arrayOf("JavaScript", "text/javascript", "js", "javascript"),
            arrayOf("Jinja2", "jinja2"),
            arrayOf("LiveScript", "text/x-livescript", "ls"),
            arrayOf("Lua", "text/x-lua", "lua"),
            arrayOf("Markdown", "text/x-markdown", "md", "markdown"),
            arrayOf("Markdown (Github)", "gfm", "md", "markdown"),
            arrayOf("Nginx", "text/nginx", "conf"),
            arrayOf("OCaml", "text/x-ocaml", "ocaml", "ml", "mli"),
            arrayOf("Matlab", "text/x-octave", "fig", "m", "mat"),
            arrayOf("Pascal", "text/x-pascal", "p", "pp", "pas"),
            arrayOf("PHP", "application/x-httpd-php", "php"),
            arrayOf("Pig Latin", "text/x-pig", "pig"),
            arrayOf("Perl", "text/x-perl", "pl"),
            arrayOf("Ini", "text/x-ini", "ini"),
            arrayOf("Properties", "text/x-properties", "properties"),
            arrayOf("Python", "text/x-python", "py"),
            //arrayOf("Qt", "text/plain", "pro"),
            arrayOf("R", "text/x-rsrc", "r"),
            arrayOf("Ruby", "text/x-ruby", "rb"),
            arrayOf("Rust", "text/x-rustsrc", "rs"),
            arrayOf("Scala", "text/x-scala", "scala"),
            arrayOf("Scheme", "text/x-scheme", "scm", "ss"),
            arrayOf("Shell", "text/x-sh", "sh", "bash"),
            arrayOf("Smalltalk", "text/x-stsrc", "st"),
            arrayOf("SQL", "text/x-sql", "sql"),
            arrayOf("SVG", "image/svg+xml", "svg"),
            arrayOf("TeX", "text/x-stex", "cls", "latex", "tex", "sty", "dtx", "ltx", "bbl"),
            arrayOf("VBScript", "text/vbscript", "vbs", "vbe", "wsc"),
            arrayOf("XML", "application/xml", "xml"),
            arrayOf("YAML", "text/x-yaml", "yml", "yaml"))

    private val mFilenameExtensionMap = HashMap<String, String>()
    private val mSupportLanguageList = ArrayList<String>()

    private val mDisplayTagMap = HashMap<String, String>()

    val languageList: List<String>
        get() = mSupportLanguageList

    const val URL_SCRIPT_WRAPPER = "javascript:(function(){%s;})()"

    init {
        for (i in FILENAME_EXTENSION_ARRAY.indices) {
            val extensions = FILENAME_EXTENSION_ARRAY[i]
            val display = extensions[0]
            val tag = extensions[1]
            mDisplayTagMap[display] = tag
            for (j in 2 until extensions.size) {
                mFilenameExtensionMap[extensions[j]] = tag
            }
        }
        mSupportLanguageList.addAll(mDisplayTagMap.keys)
        mSupportLanguageList.sort()
    }

    @JvmStatic
    fun guessCodeType(filename: String): String? {
        val filesplit = filename.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (filesplit.size <= 1)
            return null
        val extension = filesplit[filesplit.size - 1]
        return mFilenameExtensionMap[extension]
    }

    @JvmStatic
    fun getLanguageTag(language: String): String {
        return mDisplayTagMap[language]!!
    }

    @JvmStatic
    fun wrapUrlScript(script: String): String {
        return String.format(URL_SCRIPT_WRAPPER, script)
    }

}
