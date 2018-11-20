using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Array_Symmetry
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = Console.ReadLine().Split(' ');

            bool isSymmetric = true;

            for (int i = 0; i < text.Length / 2; i++)
            {
                string firstWord = text[i];
                string secondWord = text[text.Length - 1 - i];

                if (firstWord != secondWord)
                {
                    isSymmetric = false;
                    break;
                }
            }

            if (isSymmetric)
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }
        }
    }
}
