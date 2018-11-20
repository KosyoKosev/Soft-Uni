function task3(text) {
    let match = /^<message\s((?:[a-z]+="[A-Za-z0-9\s.]+"\s*)+)>((?:.|\n)+)<\/message>$/.exec(text)
    if (match){
        let to = /\bto="([A-Za-z\s.]+)"/.exec(match[1])
        let from = /\bfrom="([A-Za-z\s.]+)"/.exec(match[1])

        if (to && from){
            console.log(`<article>\n  <div>From: <span class="sender">${from[1]}</span></div>\n  <div>To: <span class="recipient">${to[1]}</span></div>`)
            console.log('  <div>')
            let lines = match[2].split('\n')
            for (let obj of lines) {
                console.log(`    <p>${obj}</p>`)
            }
            console.log('  </div>')
            console.log('</article>')

        }else {
            console.log('Missing attributes')
        }
    }else {
        console.log('Invalid message format')
    }
}
task3('<message to="Bob" from="Alice" timestamp="1497254114">Same old, same old\n'+
'Let\'s go out for a beer</message>')