"""
We are writing a Chunk processor, similar to a protocol like BitTorrent
Files are downloaded in chunks of different lengths of bytes
    - Chunks can be any size [0 - 15]
    - Chunks can be overlapping [0 - 15] & [10 - 15]
    - Chunks can arrive in any order [20 - 25] & [0 - 5]

Write a function which returns true when the file is completely downloaded i.e we have all chunks

SOLUTION:
SIZE = 5
We know the bytes needed are 0,1,2,3,4,5

CHUNKS
if we receive (0, 3)
    append CHUNKS to set(range(0,3))

To check if all files are downloaded we need to do if range(0,5) == CHUNKS
"""

FILE_SIZE = 5
CHUNK = set()

def process_chunk(start, end):
    CHUNK.update(range(start, end+1))

def is_file_downloaded():
    if CHUNK == set(range(0, FILE_SIZE+1)):
        return True
    else:
        return False

process_chunk(0,2)
# our CHUNKS are {0,1,2,3}
print(is_file_downloaded()) # Missing 4,5

process_chunk(4,5)
# our CHUNKS are {0,1,2,4,5}
print(is_file_downloaded()) # Missing 3

process_chunk(0,3)
# our CHUNKS are {0,1,2,3,4,5}
print(is_file_downloaded()) # Downloaded :)

"""
Constraint: Don't wanna store the whole CHUNK in memory
"""
