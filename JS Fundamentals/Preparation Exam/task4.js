function task4(arr) {
    let objFromArr = {}
    for (let obj of arr) {
        let system = obj['system']
        let candidate = obj['candidate']
        let votes = obj['votes']
        if (!objFromArr.hasOwnProperty(system)){
            objFromArr[system] = {}
            objFromArr[system][candidate] = 0
        }
        if (!objFromArr[system].hasOwnProperty(candidate)){
            objFromArr[system][candidate] = 0
        }
        objFromArr[system][candidate] += votes
    }
    let totalSum = 0
    for (let key in objFromArr) {
        let winner = Object.keys(objFromArr[key]).sort((a,b) => objFromArr[key][b] > objFromArr[key][a])[0]
        let sum =0
        for (let innerKey in objFromArr[key]) {
            sum += objFromArr[key][innerKey]
        }
        objFromArr[key] = {}
        objFromArr[key]['candidate'] = winner
        objFromArr[key]['votes'] = sum
        totalSum += sum
    }
    let players = {}
    for (let key in objFromArr) {
        if (!players.hasOwnProperty(objFromArr[key]['candidate'])){
            players[objFromArr[key]['candidate']] = 0
        }
        players[objFromArr[key]['candidate']] += objFromArr[key]['votes']
    }
    let sortedPlayers = Object.keys(players).sort((a,b) => players[b] > players[a])
    let sortedPercents = Object.values(players).sort((a,b) => b > a).map(a => Math.floor(a / totalSum * 100 ))
    let sortedSystem = Object.keys(objFromArr).sort((a,b) => objFromArr[b]['votes'] > objFromArr[a]['votes'])
    if (sortedPercents[0] > 50){
        if (sortedPlayers.length > 1){
            console.log(`${sortedPlayers[0]} wins with ${players[sortedPlayers[0]]} votes\nRunner up: ${sortedPlayers[1]}`)
            for (let system of sortedSystem) {
                if (objFromArr[system]['candidate'] === sortedPlayers[1]){
                    console.log(`${system}: ${objFromArr[system]['votes']}`)
                }
            }
        }else {
            console.log(`${sortedPlayers[0]} wins with ${players[sortedPlayers[0]]} votes`)
            console.log(`${sortedPlayers[0]} wins unopposed!`)
        }
    }else {
        console.log(`Runoff between ${sortedPlayers[0]} with ${sortedPercents[0]}% and ${sortedPlayers[1]} with ${sortedPercents[1]}%`)
    }
}
task4([ { system: 'Theta', candidate: 'Flying Shrimp', votes: 10 },
    { system: 'Sigma', candidate: 'Space Cow',     votes: 200 },
    { system: 'Sigma', candidate: 'Flying Shrimp', votes: 120 },
    { system: 'Tau',   candidate: 'Space Cow',     votes: 15 },
    { system: 'Sigma', candidate: 'Space Cow',     votes: 60 },
    { system: 'Tau',   candidate: 'Flying Shrimp', votes: 150 } ]
)