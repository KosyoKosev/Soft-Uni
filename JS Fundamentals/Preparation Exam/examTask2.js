function task2(matrix, arrCommand) {
    let resultMatrix = []
    for (let i = 0; i < 5; i++) {
        resultMatrix.push((matrix[i].split(' ')))
    }
    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            resultMatrix[i][j] = parseInt(resultMatrix[i][j])
        }
    }
    for (let i  = 0; i < arrCommand.length; i++) {
        let split = arrCommand[i].split(' ')
        let command = split[0]
        let index = Number(split[1])

        switch (command){
            case "breeze":
                for (let j = 0; j < 5; j++) {
                    if (resultMatrix[index][j] - 15 > 0){
                        resultMatrix[index][j] -= 15
                    }
                }
                break
            case "gale":
                for (let k = 0; k < 5; k++) {
                    if (resultMatrix[k][index] - 20 > 0){
                        resultMatrix[k][index] -= 20
                    }
                }
                break
            case "smog":
                for (let row = 0; row < 5; row++) {
                    for (let col = 0; col < 5; col++) {
                        resultMatrix[row][col] += index
                    }
                }
                break
        }
    }
    let result = []
    for (let row = 0; row < 5; row++) {
        for (let col = 0; col < 5; col++) {
            if (resultMatrix[row][col] >= 50){
                result.push(`[${row}-${col}]`)
            }
        }
    }
    if (result.length > 0){
        console.log(`Polluted areas: ${result.join(', ')}`)
    }else {
        console.log('No polluted areas')
    }

}
task2([
        "5 7 72 14 4",
        "41 35 37 27 33",
        "23 16 27 42 12",
        "2 20 28 39 14",
        "16 34 31 10 24",
    ],
    ["breeze 1", "gale 2", "smog 25"]
)