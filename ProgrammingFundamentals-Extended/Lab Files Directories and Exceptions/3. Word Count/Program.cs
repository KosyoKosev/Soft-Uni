using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace _3.Word_Count
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] words = File.ReadAllText("words.txt").ToLower().Split();
            string[] text = File.ReadAllText("text.txt").ToLower().Split(
                new []{'\n', '\r', ' ', ',', '.', '!', '?', '-'},StringSplitOptions.RemoveEmptyEntries);

            var wordCount = new Dictionary<string, int>();

            foreach (var word in words)
            {
                wordCount[word] = 0;
            }

            foreach (var word in text)
            {
                if (wordCount.ContainsKey(word))
                {
                    wordCount[word]++;
                }
            }

            wordCount = wordCount
                .OrderByDescending(x => x.Value)
                .ToDictionary(x => x.Key, x=> x.Value);
                

            foreach (var word in wordCount)
            {
                File.AppendAllText("../../output.txt",$"{word.Key} - {word.Value}\r\n");
            }
        }
    }
}
