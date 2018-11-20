function nowPlaying(parameters) {
    let artistName = parameters[1]
    let trackName = parameters[0]
    let duration = parameters[2]

    console.log(`Now Playing: ${artistName} - ${trackName} [${duration}]`)
}
nowPlaying(['Number One', 'Nelly', '4:09'])