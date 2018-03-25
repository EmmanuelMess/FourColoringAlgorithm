fun exampleOne(): World {
    val alpha = Country('α')
    val beta = Country('β')
    val eta = Country('η')

    return World(listOf(alpha, beta, eta), mapOf(
            alpha to listOf(eta, beta),
            beta to listOf(eta, alpha),
            eta to listOf(alpha, beta)
    ))
}

fun exampleTwo(): World {
    val alpha = Country('α')
    val beta = Country('β')
    val gamma = Country('γ')
    val delta = Country('δ')
    val epsilon = Country('ε')
    val zeta = Country('ζ')
    val eta = Country('η')

    return World(listOf(alpha, beta, gamma, delta, epsilon, zeta, eta), mapOf(
            alpha to listOf(eta, gamma, delta),
            beta to listOf(eta, gamma, epsilon),
            gamma to listOf(alpha, delta, epsilon, beta),
            delta to listOf(eta, alpha, zeta, gamma),
            epsilon to listOf(beta, gamma, zeta, eta),
            zeta to listOf(delta, eta, epsilon),
            eta to listOf(alpha, zeta, epsilon, beta)
    ))
}