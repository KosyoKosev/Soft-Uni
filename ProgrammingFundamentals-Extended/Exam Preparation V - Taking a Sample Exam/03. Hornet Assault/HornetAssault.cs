using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Hornet_Assault
{
    class HornetAssault
    {
        static void Main(string[] args)
        {
            var bees = Console.ReadLine().Split(' ').Select(long.Parse).ToList();
            var hornets = Console.ReadLine().Split(' ').Select(long.Parse).ToList();

            var hornetsPower = hornets.Sum();

            for (int i = 0; i < bees.Count; i++)
            {
                if (hornetsPower > bees[i])
                {
                    bees.RemoveAt(i);
                    i--;
                }
                else if (hornetsPower == bees[i])
                {
                    bees.RemoveAt(i);
                    if (hornets.Count > 0)
                    {
                        hornets.RemoveAt(0);
                    }
                    hornetsPower = hornets.Sum();
                    i--;
                }
                else 
                {
                    bees[i] -= hornetsPower;
                    if (hornets.Count > 0)
                    {
                        hornets.RemoveAt(0);
                    }
                    hornetsPower = hornets.Sum();
                }
            }

            Console.WriteLine(bees.Count > 0 ? string.Join(" ", bees) : string.Join(" ", hornets));
        }
    }
}
