using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Endurance_Rally
{
    class EnduranceRally
    {
        static void Main(string[] args)
        {
            var ragers = Console.ReadLine().Split(' ').ToArray();

            var trails = Console.ReadLine().Split(' ').Select(double.Parse).ToArray();

            var checkpoints = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            double fuel = 0;

            foreach (var rager in ragers)
            {
                char firstCharacterName = rager[0];

                fuel = (int)firstCharacterName;

                bool isFuel = true;

                for (int i = 0; i < trails.Length; i++)
                {

                    if (fuel > 0)
                    {
                        if (!checkpoints.Contains(i))
                        {
                            fuel -= trails[i];

                            if (fuel <= 0)
                            {
                                isFuel = false;

                                Console.WriteLine($"{rager} - reached {i}");
                                break;
                            }
                        }
                        else
                        {
                            if (fuel > 0)
                            {
                                fuel += trails[i];
                            }

                        }
                    }
                }

                if (isFuel)
                {
                    Console.WriteLine("{0} - fuel left {1:f2}", rager, fuel);
                }
            }
        }
    }
}
