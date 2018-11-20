function gladiatorInventory(arr) {
    let inventory = arr[0].split(' ')

    for (let i = 1; i < arr.length; i++) {
        if ('Fight!' === arr[i]){
            break
        }

        let command = arr[i].split(' ')[0]
        let currentEquipment = arr[i].split(' ')[1]
        switch (command){
            case 'Buy':
                if (!inventory.includes(currentEquipment)){
                    inventory.push(currentEquipment)
                }
                break
            case 'Trash':
                if (inventory.includes(currentEquipment)){
                    let copyInventory = inventory
                    inventory = []
                    for (let equipment of copyInventory) {
                        if (equipment !== currentEquipment){
                            inventory.push(equipment)
                        }
                    }
                }
                break
            case 'Repair':
                if (inventory.includes(currentEquipment)){
                    let copyInventory = inventory
                    inventory = []
                    for (let equipment of copyInventory) {
                        if (equipment !== currentEquipment){
                            inventory.push(equipment)
                        }
                    }
                    inventory.push(currentEquipment)
                }
                break
            case 'Upgrade':
                let equipmentForUpgrade = currentEquipment.split('-')[0]
                let upgrade = currentEquipment.split('-')[1]
                let upgradeEquipment = equipmentForUpgrade + ':' + upgrade
                if (inventory.includes(equipmentForUpgrade)){
                    let index = inventory.indexOf(equipmentForUpgrade)
                    inventory.splice(index + 1,0,upgradeEquipment)
                }
                break
        }
    }
    console.log(inventory.join(' '))
}

gladiatorInventory(['SWORD Shield Spear', 'Buy Bag', 'Trash Shield', 'Repair Spear', 'Upgrade SWORD-Steel', 'Fight!'])