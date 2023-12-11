fun main() {
    val t = readInt()
    repeat(t) {
        val n = readInt()
        val a = readInts()
        var p = IntArray(n)
        p[0] = a[0]
        for (i in 1 until n) {
            if (p[i - 1] == -1 || p[i - 1] > a[i]) {
                p[i] = -1
                continue
            }
            p[i] = maxOf(p[i - 1] + 1, a[i])
        }
        var s = IntArray(n)
        s[n - 1] = a[n - 1] + 1
        for (i in n - 2 downTo 0) {
            if (s[i + 1] == -1 || s[i + 1] <= a[i]) {
                s[i] = -1
                continue
            }
            s[i] = minOf(s[i + 1] - 1, a[i] + 1)
        }
        var found = false
        for (i in 0 until n) {
            if (i > 0 && p[i - 1] == -1) {
                continue
            }
            if (i < n - 1 && s[i + 1] == -1) {
                continue
            }
            if (i > 0 && i < n - 1 && p[i - 1] >= s[i + 1]) {
                continue
            }
            found = true
            break
        }
        println(if (found) "YES" else "NO")
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
