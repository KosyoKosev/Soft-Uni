function timer() {
    let startBtn = $('#start-timer')
    let stopBtn = $('#stop-timer')
    let timer
    let started = false
    startBtn.on('click', function () {
        if (started){
            return
        }
        started = true
        timer = setInterval(function () {
            let seconds = parseInt($('#seconds').text())
            let minutes = parseInt($('#minutes').text())
            let hours = parseInt($('#hours').text())
            seconds++
            if (seconds > 59){
                seconds = 0
                minutes++
                if (minutes > 59){
                    minutes = 0
                    hours++
                }
            }
            if (seconds < 10){
                seconds = '0' + seconds
            }
            if (minutes < 10){
                minutes = '0' + minutes
            }
            if (hours < 10){
                hours = '0' + hours
            }
            $('#seconds').text(seconds)
            $('#minutes').text(minutes)
            $('#hours').text(hours)
        }, 1000)
    })
    stopBtn.on('click', function () {
        started = false
        clearInterval(timer)
    })
}
