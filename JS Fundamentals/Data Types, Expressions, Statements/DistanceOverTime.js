function distanceOverTime(parameters) {
    let v1 = parameters[0]
    let v2 = parameters[1]
    let time = parameters[2]

    console.log(Math.abs((v1 * (time / 3600)) - (v2 * (time / 3600))) * 1000)
}
distanceOverTime([5, -5, 40])