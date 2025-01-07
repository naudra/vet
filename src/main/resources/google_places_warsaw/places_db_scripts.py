import json

# Wczytanie pliku JSON
with open('vets.txt', 'r', encoding='utf-8') as f:
    data = json.load(f)

# Generowanie skryptu SQL
sql_inserts = []
for result in data['results']:
    place_id = result['place_id']
    name = result['name'].replace("'", "''")
    address = result['formatted_address'].replace("'", "''")
    lat = result['geometry']['location']['lat']
    lng = result['geometry']['location']['lng']
    rating = result.get('rating', 'NULL')
    user_ratings_total = result.get('user_ratings_total', 'NULL')
    types = ', '.join(result['types']).replace("'", "''")
    business_status = result.get('business_status', 'NULL')
    open_now = result.get('opening_hours', {}).get('open_now', 'NULL')

    sql = f"INSERT INTO Places (place_id, name, formatted_address, lat, lng, rating, user_ratings_total, types, business_status, open_now) " \
          f"VALUES ('{place_id}', '{name}', '{address}', {lat}, {lng}, {rating}, {user_ratings_total}, '{types}', '{business_status}', {open_now});"
    sql_inserts.append(sql)

# Zapis do pliku SQL
with open('insert_vets.sql', 'w', encoding='utf-8') as f:
    f.write('\n'.join(sql_inserts))
