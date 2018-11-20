function ancientVsMemory(arrOfStrings) {
    let fullInput = ''
    for (let string of arrOfStrings) {
        fullInput += string + ' '
    }


    let numbers = []
    let split = fullInput.split(' ')
    for (let number of split) {
       numbers.push(Number(number))
    }
    for (let i = 0; i < numbers.length - 6; i++) {
        if ((numbers[i] === 32656) && (numbers[i + 1] === 19759) && (numbers[i + 2] === 32763) && (numbers[i + 3] === 0)
        && (numbers[i + 4] > 0) && (numbers[i + 5] === 0) && (numbers[i + 6] > 0)){
            let codes = []
            for (let j = i + 6; j < numbers.length; j++) {
                if (numbers[j] > 0){
                    codes.push(numbers[j])
                }else {
                    break
                }
            }
            let result = ''
            for (let number of codes) {
                result += String.fromCharCode(number)
            }
            console.log(result)
        }
    }
}

ancientVsMemory(['0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 32656 19759 32763 0',
    '5 0 71 111 115 104 111 0 0 0 0 0 0 0 0 0 32656 19759 32763 0 4 0',
    '75 105 114 111 0 0 0 0 0 0 0 0 0 0 32656 19759 32763 0 8 0 86 101',
    '114 111 110 105 107 97 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0'])