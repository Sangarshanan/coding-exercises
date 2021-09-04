"""
Roman Numerals Decoder

Symbol  |  Value
I       |   1
V       |   5
X       |   10
L       |   50
C       |   100
D       |   500
M       |   1000

Solution.decode("XXI")
Solution.decode("IV")
"""
# Solution 1

defmodule Solution do

    def decode("") do 0 end
    def decode("CM" <> tail) do 900 + decode(tail) end
    def decode("M" <> tail) do 1000 + decode(tail) end
    def decode("CD" <> tail) do 400 + decode(tail) end
    def decode("D" <> tail) do 500 + decode(tail) end
    def decode("XC" <> tail) do 90 + decode(tail) end
    def decode("XL" <> tail) do 40+ decode(tail) end
    def decode("C" <> tail) do 100 + decode(tail) end
    def decode("L" <> tail) do 50+ decode(tail) end
    def decode("IX" <> tail) do 9+ decode(tail) end
    def decode("IV" <> tail) do 4+ decode(tail) end
    def decode("X" <> tail) do 10+ decode(tail) end
    def decode("V" <> tail) do 5+ decode(tail) end
    def decode("I" <> tail) do 1+ decode(tail) end
end

# Solution 2

defmodule Solution do

  @numbers %{
    "M" => 1000,
    "D" => 500,
    "C" => 100,
    "L" => 50,
    "X" => 10,
    "V" => 5,
    "I" => 1
  }
  
  def decode(roman) do
    roman 
    |> String.graphemes()
    |> Enum.map(&@numbers[&1])
    |> Enum.reverse()
    |> Enum.scan(& if &2 > &1, do: -&1, else: &1)
    |> Enum.sum()
  end
end
