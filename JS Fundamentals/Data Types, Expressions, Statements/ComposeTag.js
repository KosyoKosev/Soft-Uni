function composeTag(parameters) {
    let fileLocation = parameters[0]
    let alternateText = parameters[1]

    console.log(`<img src="${fileLocation}" alt="${alternateText}">`)
}
composeTag(['smiley.gif', 'Smiley Face'])