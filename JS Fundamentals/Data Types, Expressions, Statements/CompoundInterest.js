function compoundInterest(parameters) {
    let sum = parameters[0]
    let interes = parameters[1] / 100
    let frequency = 12 / parameters[2]
    let time = parameters[3]

    let f = sum * Math.pow(1 + interes / frequency, frequency * time)
    console.log((f.toFixed(2)))
}
compoundInterest([100000, 5, 12, 25])