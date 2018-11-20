function task4(arr, matrix) {
    let kingdoms = {}
    for (let obj of arr) {
        let kingdom = obj['kingdom']
        let general = obj['general']
        let army = obj['army']
        if (!kingdoms.hasOwnProperty(kingdom)){
            kingdoms[kingdom] = {}
            kingdoms[kingdom][general] = 0
        }
        if (!kingdoms[kingdom].hasOwnProperty(general)){
            kingdoms[kingdom][general] = 0
        }
        kingdoms[kingdom][general] += army
    }

    let winsOfGeneral = {}
    let winnersKingdom = {}
    let lossesGeneral = {}

    for (let arr of matrix) {
        let attackKingdom = arr[0]
        let attackGeneral = arr[1]
        let defenceKingdom = arr[2]
        let defenceGeneral = arr[3]
        if (kingdoms[attackKingdom][attackGeneral] !== kingdoms[defenceKingdom][defenceGeneral] && attackKingdom !== defenceKingdom){
            if (kingdoms[attackKingdom][attackGeneral] > kingdoms[defenceKingdom][defenceGeneral]){
                if (!winnersKingdom.hasOwnProperty(attackKingdom)){
                    winnersKingdom[attackKingdom] = 0
                }
                winnersKingdom[attackKingdom]++
                if (!winsOfGeneral.hasOwnProperty(attackGeneral)){
                    winsOfGeneral[attackGeneral] = 0
                }
                winsOfGeneral[attackGeneral]++
                if (!lossesGeneral.hasOwnProperty(defenceGeneral)){
                    lossesGeneral[defenceGeneral] = 0
                }
                lossesGeneral[defenceGeneral]++
                kingdoms[attackKingdom][attackGeneral] = Math.floor(kingdoms[attackKingdom][attackGeneral] + kingdoms[attackKingdom][attackGeneral] * 0.1)
                kingdoms[defenceKingdom][defenceGeneral] = Math.floor(kingdoms[defenceKingdom][defenceGeneral] - kingdoms[defenceKingdom][defenceGeneral] * 0.1)
            }else {
                if (!winnersKingdom.hasOwnProperty(defenceKingdom)){
                    winnersKingdom[defenceKingdom] = 0
                }
                winnersKingdom[defenceKingdom]++
                if (!winsOfGeneral.hasOwnProperty(defenceGeneral)){
                    winsOfGeneral[defenceGeneral] = 0
                }
                winsOfGeneral[defenceGeneral]++
                if (!lossesGeneral.hasOwnProperty(attackGeneral)){
                    lossesGeneral[attackGeneral] = 0
                }
                lossesGeneral[attackGeneral]++
                kingdoms[attackKingdom][attackGeneral] = Math.floor(kingdoms[attackKingdom][attackGeneral] - kingdoms[attackKingdom][attackGeneral] * 0.1)
                kingdoms[defenceKingdom][defenceGeneral] = Math.floor(kingdoms[defenceKingdom][defenceGeneral] + kingdoms[defenceKingdom][defenceGeneral] * 0.1)
            }
        }
    }

    let sortedWinnerKingdom = Object.keys(winnersKingdom).sort((a, b) => winnersKingdom[b] > winnersKingdom[a])
    if (winnersKingdom[sortedWinnerKingdom[0]] === winnersKingdom[sortedWinnerKingdom[1]]) {
        sortedWinnerKingdom = Object.keys(winnersKingdom).sort((a, b) => a > b)
    }

    console.log(`Winner: ${sortedWinnerKingdom[0]}`)
    let sortedGeneral = Object.keys(kingdoms[sortedWinnerKingdom[0]]).sort((a, b) =>kingdoms[sortedWinnerKingdom[0]][b] - kingdoms[sortedWinnerKingdom[0]][a])
    for (let general of sortedGeneral) {
        console.log(`/\\general: ${general}`)
        console.log(`---army: ${Math.floor(kingdoms[sortedWinnerKingdom[0]][general])}`)
        console.log(`---wins: ${winsOfGeneral.hasOwnProperty(general)? Math.floor(winsOfGeneral[general]) : 0}`)
        console.log(`---losses: ${lossesGeneral.hasOwnProperty(general)? Math.floor(lossesGeneral[general]) : 0}`)

    }
}
task4([ { kingdom: "Maiden Way", general: "Merek", army: 5000 },
        { kingdom: "Stonegate", general: "Ulric", army: 4900 },
        { kingdom: "Stonegate", general: "Doran", army: 70000 },
        { kingdom: "YorkenShire", general: "Quinn", army: 0 },
        { kingdom: "YorkenShire", general: "Quinn", army: 2000 },
        { kingdom: "Maiden Way", general: "Berinon", army: 100000 } ],
    [ ["YorkenShire", "Quinn", "Stonegate", "Ulric"],
        ["Stonegate", "Ulric", "Stonegate", "Doran"],
        ["Stonegate", "Doran", "Maiden Way", "Merek"],
        ["Stonegate", "Ulric", "Maiden Way", "Merek"],
        ["Maiden Way", "Berinon", "Stonegate", "Ulric"] ]

)