function airPollution(matrix, arr) {
    let resultMatrix = []
    let result = []
    for (let i = 0; i < 5; i++) {
        resultMatrix.push(matrix[i].split(' '))
    }

    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            resultMatrix[i][j] = parseInt(resultMatrix[i][j])
        }
    }
    for (let i = 0; i < arr.length; i++) {
        let split = arr[i].split(' ')
        let command = split[0]
        let index = parseInt(split[1])

        switch (command){
            case 'breeze':
                for (let j = 0; j < 5; j++) {
                    if (resultMatrix[index][j] > 15){
                        resultMatrix[index][j] -= 15
                    }
                }
                break
            case 'gale':
                for (let j = 0; j < 5; j++) {
                    if (resultMatrix[j][index] > 20){
                        resultMatrix[j][index] -= 20
                    }
                }
                break
            case 'smog':
                for (let j = 0; j < 5; j++) {
                    for (let k = 0; k < 5; k++) {
                        resultMatrix[j][k] += index
                    }
                }
                break
        }
    }

    for (let j = 0; j < 5; j++) {
        for (let k = 0; k < 5; k++) {
            if (resultMatrix[j][k] >= 50){
                let poisonBlock = `[${j}-${k}]`
                result.push(poisonBlock)
            }
        }
    }
    if (result.length > 0) {
        console.log(`Polluted areas: ${result.join(', ')}`)
    }else console.log('No polluted areas')
}

airPollution([
        "5 7 72 14 4",
        "41 35 37 27 33",
        "23 16 27 42 12",
        "2 20 28 39 14",
        "16 34 31 10 24",
    ],
    ["breeze 1", "gale 2", "smog 25"]
)