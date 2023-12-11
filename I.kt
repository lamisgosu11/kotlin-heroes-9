fun main() {
    val (n, k, c) = readInts()
    val t = readLn()
    val mod = 998244353
    val p = n / k
    val dp = LongArray(p + 1)
    dp[0] = 1
    for (ch in t) {
        val x = ch.code - 'a'.code
        var coeff = 1L
        for (i in 0..p) {
            dp[i] = dp[i] * coeff % mod
            coeff = coeff * c % mod
        }
        for (i in 0 until p) {
            dp[i + 1] = (dp[i + 1] + dp[i] * (c - x - 1)) % mod
        }
        coeff = 1
        for (i in p downTo 0) {
            dp[i] = dp[i] * coeff % mod
            coeff = coeff * (c - x) % mod
        }
    }
    var ans = dp.sum() % mod
    repeat(n - t.length * (p + 1)) {
        ans = ans * c % mod
    }
    println(ans)
}
 
private fun readLn() = readLine()!!
private fun readInt() = readLn().toInt()
private fun readLong() = readLn().toLong()
private fun readDouble() = readLn().toDouble()
private fun readStrings() = readLn().split(" ")
private fun readInts() = readStrings().map { it.toInt() }
private fun readLongs() = readStrings().map { it.toLong() }
private fun readDoubles() = readStrings().map { it.toDouble() }