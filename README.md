# Resourceful Block Sounds

## What is this?
Resourceful Block Sounds allows resource pack makers to define their own block sound groups, and assign blocks to them!

## Creating a sound group
- Create a JSON file and place it in the directory: assets/minecraft/rbs/groups/<your_sound_groups_name>.json
- The content of the file should look like this:
   ```
    {
      "pitch": 1,
      "volume": 1,
      "break": "block.wood.break",
      "step": "block.wood.step",
      "place": "block.wood.place",
      "hit": "block.wood.hit",
      "fall": "block.wood.fall"
    }
    ```
 - To reference this sound group, you would type `"minecraft:your_sound_groups_name"` where `your_sound_groups_name` is the name of the file you created.

## Changing blocks sounds
- Create a JSON file and place it in the directory: assets/minecraft/rbs/lists/<list_name>.json
- The content of the file should look like this:
  ```
  {
    "group": "minecraft:wood",
    "blocks": [
      "minecraft:dirt",
      "minecraft:grass_block"
    ]
  }
  ```
- This makes it so that dirt and dirt blocks sound like wood
- All Minecraft sound groups are available to use out of the box, the complete list being:
  - `minecraft:intentionally_empty`
  - `minecraft:wood`
  - `minecraft:gravel`
  - `minecraft:grass`
  - `minecraft:lily_pad`
  - `minecraft:stone`
  - `minecraft:metal`
  - `minecraft:glass`
  - `minecraft:wool`
  - `minecraft:sand`
  - `minecraft:snow`
  - `minecraft:powder_snow`
  - `minecraft:ladder`
  - `minecraft:anvil`
  - `minecraft:slime`
  - `minecraft:honey`
  - `minecraft:wet_grass`
  - `minecraft:coral`
  - `minecraft:bamboo`
  - `minecraft:bamboo_sapling`
  - `minecraft:scaffolding`
  - `minecraft:sweet_berry_bush`
  - `minecraft:crop`
  - `minecraft:stem`
  - `minecraft:vine`
  - `minecraft:nether_wart`
  - `minecraft:lantern`
  - `minecraft:nether_stem`
  - `minecraft:nylium`
  - `minecraft:fungus`
  - `minecraft:roots`
  - `minecraft:shroomlight`
  - `minecraft:weeping_vines`
  - `minecraft:weeping_vines_low_pitch`
  - `minecraft:soul_sand`
  - `minecraft:soul_soil`
  - `minecraft:basalt`
  - `minecraft:wart_block`
  - `minecraft:netherrack`
  - `minecraft:nether_bricks`
  - `minecraft:nether_sprouts`
  - `minecraft:nether_ore`
  - `minecraft:bone`
  - `minecraft:netherite`
  - `minecraft:ancient_debris`
  - `minecraft:lodestone`
  - `minecraft:chain`
  - `minecraft:nether_gold_ore`
  - `minecraft:gilded_blackstone`
  - `minecraft:candle`
  - `minecraft:amethyst_block`
  - `minecraft:amethyst_cluster`
  - `minecraft:small_amethyst_bud`
  - `minecraft:medium_amethyst_bud`
  - `minecraft:large_amethyst_bud`
  - `minecraft:tuff`
  - `minecraft:calcite`
  - `minecraft:dripstone_block`
  - `minecraft:pointed_dripstone`
  - `minecraft:copper`
  - `minecraft:cave_vines`
  - `minecraft:spore_blossom`
  - `minecraft:azalea`
  - `minecraft:flowering_azalea`
  - `minecraft:moss_carpet`
  - `minecraft:pink_petals`
  - `minecraft:moss_block`
  - `minecraft:big_dripleaf`
  - `minecraft:small_dripleaf`
  - `minecraft:rooted_dirt`
  - `minecraft:hanging_roots`
  - `minecraft:azalea_leaves`
  - `minecraft:sculk_sensor`
  - `minecraft:sculk_catalyst`
  - `minecraft:sculk`
  - `minecraft:sculk_vein`
  - `minecraft:sculk_shrieker`
  - `minecraft:glow_lichen`
  - `minecraft:deepslate`
  - `minecraft:deepslate_bricks`
  - `minecraft:deepslate_tiles`
  - `minecraft:polished_deepslate`
  - `minecraft:froglight`
  - `minecraft:frogspawn`
  - `minecraft:mangrove_roots`
  - `minecraft:muddy_mangrove_roots`
  - `minecraft:mud`
  - `minecraft:mud_bricks`
  - `minecraft:packed_mud`
  - `minecraft:hanging_sign`
  - `minecraft:nether_wood_hanging_sign`
  - `minecraft:bamboo_wood_hanging_sign`
  - `minecraft:bamboo_wood`
  - `minecraft:nether_wood`
  - `minecraft:cherry_wood`
  - `minecraft:cherry_sapling`
  - `minecraft:cherry_leaves`
  - `minecraft:cherry_wood_hanging_sign`
  - `minecraft:chiseled_bookshelf`
  - `minecraft:suspicious_sand`
  - `minecraft:suspicious_gravel`
  - `minecraft:decorated_pot`
  - `minecraft:decorated_pot_shatter`
