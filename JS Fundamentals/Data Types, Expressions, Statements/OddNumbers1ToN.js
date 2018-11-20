function oddNumbersOf1ToN(lastNumber) {
    for (var i = 1; i <= lastNumber; i++) {
        if (i % 2 === 0){
            continue
        }else {
            console.log(i)
        }
        
    }
}
oddNumbersOf1ToN(4)