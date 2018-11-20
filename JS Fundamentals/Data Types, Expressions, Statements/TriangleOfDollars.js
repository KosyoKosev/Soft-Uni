function triangleOfDollars(number) {
    let line = ''
    for (var i = 0; i < number; i++) {
        console.log(line += '$')
    }
}
triangleOfDollars(3)