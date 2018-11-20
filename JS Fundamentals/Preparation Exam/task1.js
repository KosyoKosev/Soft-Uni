function task1(sise, increment) {
    let stone = 0
    let marble = 0
    let lapis = 0
    let gold = 0

    let totalRows = Math.ceil(sise / 2)
    for (var i = 1; i <= totalRows - 1; i++) {
        let currentStone = (sise - 2) * (sise - 2)
        stone += currentStone
        if (i % 5 !== 0){
            marble += (sise * sise) - currentStone
        }else {
            lapis += (sise * sise) - currentStone
        }
        sise -= 2
    }

    console.log(`Stone required: ${Math.ceil(stone * increment)}`)
    console.log(`Marble required: ${Math.ceil(marble * increment)}`)
    console.log(`Lapis Lazuli required: ${Math.ceil(lapis * increment)}`)
    console.log(`Gold required: ${Math.ceil(sise * sise * increment)}`)
    console.log(`Final pyramid height: ${Math.floor(totalRows * increment)}`)
}
task1(11, 1)