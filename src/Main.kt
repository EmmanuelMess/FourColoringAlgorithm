enum class Color { BLUE, GREY, GREEN, RED }

data class Country(val name: Char) {
    var current = 0
}

data class World(val countryList: List<Country>, val adjacencyList: Map<Country, List<Country>>)

fun main(args: Array<String>) {
    val working = findColoring(::exampleTwo)

    if(working != null) {
        for (country in working.countryList) {
            println("${country.name}: ${Color.values()[country.current]}")
        }
    } else {
        println("Error!")
    }
}

fun findColoring(world: () -> World) = dfs(world)

fun dfs(world: () -> World, countryIndex: Int = 0, lastWorld: World? = null): World? {
    val cpy = world.invoke()

    if(lastWorld != null) {
        for (alreadyColored in 0..countryIndex) {
            cpy.countryList[alreadyColored].current = lastWorld.countryList[alreadyColored].current;
        }
    }

    val country = cpy.countryList[countryIndex]

    while (country.current < Color.values().size) {
        if (checkCountry(country, cpy)) {
            if (countryIndex == cpy.countryList.size-1) {
                return cpy
            }

            return dfs(world, countryIndex+1, cpy)
        }

        country.current++
    }

    return null
}

fun checkCountry(country: Country, world: World): Boolean {
    val adjacentCountries =  world.adjacencyList[country] ?: throw NullPointerException()

    for(adjacentCountry in adjacentCountries) {
        if(adjacentCountry.current == Color.values().size) {
            return false
        }

        if(adjacentCountry.current == country.current) {
            adjacentCountry.current++
            if(!checkCountry(adjacentCountry, world)) {
                return false
            }
        }
    }
    return true
}