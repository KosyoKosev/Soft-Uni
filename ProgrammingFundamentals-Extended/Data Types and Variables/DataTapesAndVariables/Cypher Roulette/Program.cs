using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cypher_Roulette
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string result = string.Empty;
            string check = string.Empty;
            string checkSpin = "spin";
            int counter = 0;

            for (int i = 0; i < n; i++)
            {
                
                
                string text = Console.ReadLine();

                if (check.Equals(text))
                {
                    result = string.Empty;
                }
                else if (text.Equals("spin"))
                {
                    counter++;

                    string newText = Console.ReadLine();

                    if(counter % 2 == 0)
                    {
                        result += newText;
                    }
                    else
                    {
                        result = newText + result;

                    }

                    check = newText;

                    if (check.Equals(checkSpin))
                    {
                        result = string.Empty;
                    }

                    if (newText.Equals("spin"))
                    {
                        i--;
                        
                    }
                }
                else
                {
                    result += text;
                    check = text;
                }

            }

            Console.WriteLine(result);
        }
    }
}
