using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.Average_Character_Delimiter
{
    class Program
    {
        static void Main(string[] args)
        {
            var text = Console.ReadLine().Split(' ').ToList();

            var characterList = new List<char>();

            var sumParseCharacter = 0;

            int number = 0;

            int counter = 0;

            for (int i = 0; i < text.Count; i++)
            {
                var elementText = text[i];
                for (int j = 0; j < elementText.Length; j++)
                {
                    characterList.Add(elementText[j]);
                    number = characterList[counter];
                    counter++;
                    sumParseCharacter += number;
                }
            }

            var indexASCIITable = sumParseCharacter / characterList.Count;
            char character = ' ';
            if (indexASCIITable > 96 && indexASCIITable < 123)
            {
                 character = (char)(indexASCIITable - 32);
            }
            else
            {
                 character = (char)(indexASCIITable);
            }

            for (int i = 0; i < text.Count; i++)
            {
                if (i == text.Count - 1)
                {
                    Console.Write(text[i]);
                }
                else 
                {
                    Console.Write(text[i] + character);
                }
            }

            Console.WriteLine();
        }
    }
}
