function rounding(parameters) {
    let number = parameters[0]
    let precision = parameters[1]

    console.log(precision > 15 ? number.toFixed(15) : number.toFixed(precision))
}
rounding([3.1415926535897932384626433832795, 2])