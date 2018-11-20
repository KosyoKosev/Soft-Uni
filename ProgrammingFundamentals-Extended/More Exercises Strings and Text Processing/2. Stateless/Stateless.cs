using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.Stateless
{
    class Stateless
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine();

            var stateless = string.Empty;
            var fiction = string.Empty;

            var counter = 0;

            while (input != "collapse")
            {
                counter++;

                if (counter % 2 != 0)
                {
                    stateless = input;
                }
                else
                {
                    fiction = input;
                }

                if (counter >= 2 && fiction != "")
                {
                    while (fiction.Length >= 1)
                    {
                        stateless = stateless.Replace(fiction,"");
                        fiction = fiction.Remove(fiction.Length - 1);
                        
                        if (fiction.Length > 1)
                        {
                            fiction = fiction.Remove(0, 1);
                        }
                        else
                        {
                            fiction = string.Empty;
                        }
                        
                    }

                    if (stateless == "")
                    {
                        Console.WriteLine("(void)");
                    }
                    else
                    {
                        Console.WriteLine(stateless.Trim());
                    }
                }
                
                input = Console.ReadLine();
            }
        }
    }
}
