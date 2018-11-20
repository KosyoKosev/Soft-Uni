using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _6.Winecraft
{
    class Winecraft
    {
        static void Main(string[] args)
        {
            var grapes = Console.ReadLine().Split().Select(int.Parse).ToList();
            var round = int.Parse(Console.ReadLine());

            while (grapes.Count > round)
            {
                for (int i = 0; i < round; i++)
                {
                    for (int j = 0; j < grapes.Count; j++)
                    {
                        grapes[j]++;
                    }

                    for (int k = 0; k < grapes.Count; k++)
                    {
                        var primeIndex = 0;
                        var lastIndex = grapes.Count - 1;

                        if (k > primeIndex && k < lastIndex)
                        {
                            
                            if (grapes[k] > grapes[k - 1] && grapes[k] > grapes[k + 1])
                            {
                                grapes[k]--;

                                if (grapes[k - 1] > 0)
                                {
                                    grapes[k]++;
                                    grapes[k - 1] = Math.Max(grapes[k - 1] - 2, 0);
                                }

                                if (grapes[k + 1] > 0)
                                {
                                    grapes[k]++;
                                    grapes[k + 1] = Math.Max(grapes[k + 1] - 2, 0);

                                }
                            }
                        }
                    }
                }
                

                for (int i = 0; i < grapes.Count; i++)
                {
                    if (grapes[i] <= round)
                    {
                        grapes.RemoveAt(i);
                        i--;
                    }
                }
            }

            Console.WriteLine(string.Join(" ", grapes));
        }
    }
}
