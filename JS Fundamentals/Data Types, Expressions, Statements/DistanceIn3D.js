function distanceIn3D(parameters) {
    let x1 = parameters[0]
    let y1 = parameters[1]
    let z1 = parameters[2]
    let x2 = parameters[3]
    let y2 = parameters[4]
    let z2 = parameters[5]

    let distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2))
    console.log(distance)
}
distanceIn3D([3.5, 0, 1, 0, 2, -1])