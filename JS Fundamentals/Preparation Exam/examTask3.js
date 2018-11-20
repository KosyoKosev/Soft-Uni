function task3(string) {
    let match = /.*<svg>.*<\/svg>.*/.exec(string)
    if (match){
        let cat = /<cat><text>.*\[.+\]<\/text><\/cat>\s*<cat>((?:<g><val>(?:[0-9]+)<\/val>(?:[0-9]+)<\/g>)+)<\/cat>/.exec(match)[0]
        if (cat){
            let label = /<cat><text>.*\[.+\]<\/text><\/cat>\s*<cat>.*<\/cat>/.exec(cat)[1]
            let vote = /<g><val>([0-9]+)<\/val>([0-9]+)<\/g>/.exec(cat)[2]
            let valueVote = /<g><val>([0-9]+)<\/val>([0-9]+)<\/g>/
            let value = []
            let voteArr = []
            while (valueArr = valueVote.exec(cat)){
                value.push(voteArr)
            }
        }

    }
}
task3('<p>Some random text</p><svg><cat><text>How do you rate our food? [Food - General]</text></cat><cat><g><val>1</val>0</g><g><val>2</val>1</g><g><val>3</val>3</g><g><val>4</val>10</g><g><val>5</val>7</g></cat></svg><p>Some more random text</p>')