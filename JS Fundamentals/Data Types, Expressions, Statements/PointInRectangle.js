function pointInRectangle(parameters) {
    let x = parameters[0]
    let y = parameters[1]
    let xMin = parameters[2]
    let xMax = parameters[3]
    let yMin = parameters[4]
    let yMax = parameters[5]

    if (x >= xMin && x <= xMax && y >= yMin && y <= yMax){
        console.log('inside')
    }else {
        console.log('outside')
    }
}
pointInRectangle([8 ,-1,2,12 ,-3,3])