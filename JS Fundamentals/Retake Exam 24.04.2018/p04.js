function arenaTier(arrOfStrings) {
    let gladiators = {}
    let gladiatorsSkill = {}

    for (let string of arrOfStrings) {
        if ('Ave Cesar' === string){
            break
        }
        let split = string.split(' -> ')
        if (split.length > 1){
            let nameGladiator = split[0]
            let technique = split[1]
            let skill = Number(split[2])
            if (!gladiators.hasOwnProperty(nameGladiator)) {
                gladiators[nameGladiator] = {}
                gladiatorsSkill[nameGladiator] = 0
            }
            if (!gladiators[nameGladiator].hasOwnProperty(technique)){
                gladiators[nameGladiator][technique] = skill
                gladiatorsSkill[nameGladiator] += skill
            }else {
                if (gladiators[nameGladiator][technique] < skill){
                    let skillForRemove = gladiators[nameGladiator][technique]
                    gladiators[nameGladiator][technique] = skill
                    gladiatorsSkill[nameGladiator] -= skillForRemove
                    gladiatorsSkill[nameGladiator] += skill
                }
            }
        }else {
            let split = string.split(' vs ')
            let firstGladiator = split[0]
            let secondGladiator = split[1]
            if (gladiators.hasOwnProperty(firstGladiator) && gladiators.hasOwnProperty(secondGladiator)){
                for (let obj in gladiators[firstGladiator]) {
                    for (let obj1 in gladiators[secondGladiator]) {
                        if (obj1 === obj){
                            if (gladiatorsSkill[firstGladiator] > gladiatorsSkill[secondGladiator]){
                                delete gladiators[secondGladiator]
                                delete gladiatorsSkill[secondGladiator]
                            }else {
                                delete gladiators[firstGladiator]
                                delete gladiatorsSkill[firstGladiator]
                            }
                        }
                    }
                }
            }
        }
    }
    let sortredGladiatorsSkill = Object.keys(gladiatorsSkill).sort((a,b) => gladiatorsSkill[b] - gladiatorsSkill[a])
    for (let gladiator of sortredGladiatorsSkill) {
        console.log(`${gladiator}: ${gladiatorsSkill[gladiator]} skill`)
        let sortedTechnique = Object.keys(gladiators[gladiator]).sort((a,b) => gladiators[gladiator][b] - gladiators[gladiator][a])
        for (let technique of sortedTechnique) {
            console.log(`- ${technique} <!> ${gladiators[gladiator][technique]}`)
        }
    }
}

arenaTier(['Pesho -> Duck -> 400',
    'Julius -> Shield -> 150',
    'Gladius -> Heal -> 200',
    'Gladius -> Support -> 250',
    'Gladius -> Shield -> 250',
    'Pesho vs Gladius',
    'Gladius vs Julius',
    'Gladius vs Gosho',
    'Ave Cesar'
])