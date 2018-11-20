using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Sino_The_Walker
{
    class SinoTheWalker
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine();

            var split = input.Split(':');

            int hours = Int32.Parse(split[0]);
            int minutes = Int32.Parse(split[1]);
            int seconds = Int32.Parse(split[2]);

            TimeSpan time = new TimeSpan(hours,minutes,seconds);

            var steps = decimal.Parse(Console.ReadLine());
            var timeSteps = decimal.Parse(Console.ReadLine());

            int takeTime = (int)(steps * timeSteps % (60 * 60 * 24));

            time += TimeSpan.FromSeconds(takeTime);

            Console.WriteLine("Time Arrival: {0:00}:{1:00}:{2:00}", time.Hours, time.Minutes, time.Seconds);

        }
    }
}
