fun main() {
    val t = readInt()
    repeat(t) {
        val s = readLn()
        var i = s.length
        while (i > 0 && s[i - 1].isDigit()) {
            i -= 1
        }
        while (i < s.length && s[i] == '0') {
            i += 1
        }
        println(s.substring(0, i))
    }
}

private fun readLn() = readLine()!!
private fun readInt() = readLn().toInt()
private fun readLong() = readLn().toLong()
private fun readDouble() = readLn().toDouble()
private fun readStrings() = readLn().split(" ")
private fun readInts() = readStrings().map { it.toInt() }
private fun readLongs() = readStrings().map { it.toLong() }
private fun readDoubles() = readStrings().map { it.toDouble() }
