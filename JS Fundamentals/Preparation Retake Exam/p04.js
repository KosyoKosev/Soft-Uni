function gameOfEpicness(matrixKingdom, matrixAttack) {
    let kingdoms = {}
    for (let kingdomStore of matrixKingdom) {
        let kingdom = kingdomStore.kingdom
        let general = kingdomStore.general
        let army = kingdomStore.army
        if (!kingdoms.hasOwnProperty(kingdom)){
            kingdoms[kingdom] = {}
        }
        if (!kingdoms[kingdom].hasOwnProperty(general)){
            kingdoms[kingdom][general] = {'army': 0, 'wins': 0, 'losses': 0}
        }
        kingdoms[kingdom][general]['army'] += army
    }
    let kingdomWins ={}

    for (let batle of matrixAttack) {
        let kingdomAttack = batle[0]
        let generalAttack = batle[1]
        let kingdomDefence = batle[2]
        let generalDefence = batle[3]

        if (kingdomAttack !== kingdomDefence && generalAttack !== generalDefence){
            if (kingdoms[kingdomAttack][generalAttack].army > kingdoms[kingdomDefence][generalDefence].army){
                kingdoms[kingdomAttack][generalAttack].army = Math.round(kingdoms[kingdomAttack][generalAttack].army * 1.1)
                kingdoms[kingdomDefence][generalDefence].army = Math.round(kingdoms[kingdomDefence][generalDefence].army * 0.9)
                kingdoms[kingdomAttack][generalAttack].wins++
                kingdoms[kingdomDefence][generalDefence].losses++
                if (!kingdomWins.hasOwnProperty(kingdomAttack)){
                    kingdomWins[kingdomAttack] = 0
                }
                kingdomWins[kingdomAttack]++
            }
            if (kingdoms[kingdomAttack][generalAttack].army < kingdoms[kingdomDefence][generalDefence].army){
                kingdoms[kingdomAttack][generalAttack].army = Math.floor(kingdoms[kingdomAttack][generalAttack].army * 0.9)
                kingdoms[kingdomDefence][generalDefence].army = Math.floor(kingdoms[kingdomDefence][generalDefence].army * 1.1)
                kingdoms[kingdomAttack][generalAttack].losses++
                kingdoms[kingdomDefence][generalDefence].wins++
                if (!kingdomWins.hasOwnProperty(kingdomDefence)){
                    kingdomWins[kingdomDefence] = 0
                }
                kingdomWins[kingdomDefence]++
            }
        }
    }

    let sortedKingdomWins = Object.keys(kingdomWins).sort((a,b) => kingdomWins[b] - kingdomWins[a])
    if (kingdomWins[sortedKingdomWins[0]] === kingdomWins[sortedKingdomWins[1]]){
        sortedKingdomWins = Object.keys(kingdomWins).sort((a,b) => a.compeb)
    }

    console.log(`Winner: ${sortedKingdomWins[0]}`)
    let sortedGenerals = Object.keys(kingdoms[sortedKingdomWins[0]]).sort((a,b) => kingdoms[sortedKingdomWins[0]][b].army
    > kingdoms[sortedKingdomWins[0]][a].army)
    for (let general of sortedGenerals) {
        console.log(`/\\general: ${general}`)
        console.log(`---army: ${kingdoms[sortedKingdomWins[0]][general].army}`)
        console.log(`---wins: ${kingdoms[sortedKingdomWins[0]][general].wins}`)
        console.log(`---losses: ${kingdoms[sortedKingdomWins[0]][general].losses}`)
    }
}

// gameOfEpicness([ { kingdom: "Maiden Way", general: "Merek", army: 5000 },
//         { kingdom: "Stonegate", general: "Ulric", army: 4900 },
//         { kingdom: "Stonegate", general: "Doran", army: 70000 },
//         { kingdom: "YorkenShire", general: "Quinn", army: 0 },
//         { kingdom: "YorkenShire", general: "Quinn", army: 2000 },
//         { kingdom: "Maiden Way", general: "Berinon", army: 100000 } ],
//     [ ["YorkenShire", "Quinn", "Stonegate", "Ulric"],
//         ["Stonegate", "Ulric", "Stonegate", "Doran"],
//         ["Stonegate", "Doran", "Maiden Way", "Merek"],
//         ["Stonegate", "Ulric", "Maiden Way", "Merek"],
//         ["Maiden Way", "Berinon", "Stonegate", "Ulric"] ]
// )
// gameOfEpicness([ { kingdom: "Stonegate", general: "Ulric", army: 5000 },
//         { kingdom: "YorkenShire", general: "Quinn", army: 5000 },
//         { kingdom: "Maiden Way", general: "Berinon", army: 1000 } ],
//     [ ["YorkenShire", "Quinn", "Stonegate", "Ulric"],
//         ["Maiden Way", "Berinon", "YorkenShire", "Quinn"] ]
// )
gameOfEpicness([ { kingdom: "Maiden Way", general: "Merek", army: 5000 },
        { kingdom: "Stonegate", general: "Ulric", army: 4900 },
        { kingdom: "Stonegate", general: "Doran", army: 70000 },
        { kingdom: "YorkenShire", general: "Quinn", army: 0 },
        { kingdom: "YorkenShire", general: "Quinn", army: 2000 } ],
    [ ["YorkenShire", "Quinn", "Stonegate", "Doran"],
        ["Stonegate", "Ulric", "Maiden Way", "Merek"] ]
)