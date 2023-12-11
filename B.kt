fun main() {
    val t = readInt()
    repeat(t) {
        val s = readLn()
        var i = s.lastIndexOf('+')
        var j = s.indexOf('-')
        if (i == -1 || j == -1 || i < j) {
            i = 0
            j = 0
        }
        var b = 0
        var fail = false
        for (k in 0 until s.length) {
            var cur = if (s[k] == '+') +1 else -1
            if (k == i) {
                cur = -cur
            }
            if (k == j) {
                cur = -cur
            }
            b += cur
            if (b < 0) {
                fail = true
                break
            }
        }
        println(if (fail) "-1" else "${i+1} ${j+1}")
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
