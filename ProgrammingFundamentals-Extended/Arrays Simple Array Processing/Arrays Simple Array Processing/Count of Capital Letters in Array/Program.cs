using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Count_of_Capital_Letters_in_Array
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = Console.ReadLine().Split(' ');

            int count = 0;

            for (int i = 0; i < text.Length; i++)
            {
                string currentWord = text[i];

                if (currentWord.Length == 1)
                {
                    char character = currentWord[0];

                    if (character >= 'A' && character <= 'Z')
                    {
                        count++;
                    }
                }
            }

            Console.WriteLine(count);
        }
    }
}
