using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Hornet_Wings
{
    class HornetWings
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            double m = double.Parse(Console.ReadLine());
            int p = int.Parse(Console.ReadLine());

            double distance = (n / 1000) * m;
            long time = (long) ((n / p) * 5) + (n / 100);
            

            Console.WriteLine($"{distance:F2} m.");
            Console.WriteLine($"{time} s.");

        }
    }
}
