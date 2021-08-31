# https://www.codewars.com/kata/515f51d438015969f7000013/train/elixir

# pyramid(0) => [ ]
# pyramid(1) => [ [1] ]
# pyramid(2) => [ [1], [1, 1] ]
# pyramid(3) => [ [1], [1, 1], [1, 1, 1] ]

defmodule Kata do
  def pyramid(0) do
  	[]
  end
  def pyramid(n) do
  	for i <- 1..n, do:
  		List.duplicate(1,i)
  end
end
