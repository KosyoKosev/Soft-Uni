function gladiatorExpenses(lost, helmetPrice, swordPrice, shieldPrice, armorPrice) {
    let helmetTrash = 0
    let swordTrash = 0
    let shieldTrash = 0
    let armorTrash = 0
    for (let i = 1; i <= lost; i++) {
        if (i % 2 === 0){
            helmetTrash++
        }
        if (i % 3 === 0){
            swordTrash++
        }
        if (i % 6 === 0){
            shieldTrash++
        }

    }
    armorTrash = Math.floor(shieldTrash / 2)

    let price = (helmetTrash * helmetPrice) + (swordTrash * swordPrice) + (shieldTrash * shieldPrice) + (armorTrash * armorPrice)
    console.log(`Gladiator expenses: ${price.toFixed(2)} aureus`)
}

gladiatorExpenses(23,12.50,21.50,40,200)